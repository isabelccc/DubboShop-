package com.imooc.curator.checkConfig;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.commons.lang3.StringUtils;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.framework.recipes.cache.PathChildrenCache.StartMode;
import org.apache.curator.retry.RetryNTimes;

import com.imooc.utils.JsonUtils;
import com.imooc.utils.RedisConfig;

public class Client3 {

	public CuratorFramework client = null;
	public static final String zkServerPath = "192.168.1.110:2181";

	public Client3() {
		RetryPolicy retryPolicy = new RetryNTimes(3, 5000);
		client = CuratorFrameworkFactory.builder()
				.connectString(zkServerPath)
				.sessionTimeoutMs(10000).retryPolicy(retryPolicy)
				.namespace("workspace").build();
		client.start();
	}
	
	public void closeZKClient() {
		if (client != null) {
			this.client.close();
		}
	}
	
//	public final static String CONFIG_NODE = "/super/imooc/redis-config";
	public final static String CONFIG_NODE_PATH = "/super/imooc";
	public final static String SUB_PATH = "/redis-config";
	public static CountDownLatch countDown = new CountDownLatch(1);
	
	public static void main(String[] args) throws Exception {
		Client3 cto = new Client3();
		System.out.println("client3 started successfully...");
		
		final PathChildrenCache childrenCache = new PathChildrenCache(cto.client, CONFIG_NODE_PATH, true);
		childrenCache.start(StartMode.BUILD_INITIAL_CACHE);
		
		// Add listener event
		childrenCache.getListenable().addListener(new PathChildrenCacheListener() {
			public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
				// Listen for node changes
				if(event.getType().equals(PathChildrenCacheEvent.Type.CHILD_UPDATED)){
					String configNodePath = event.getData().getPath();
					if (configNodePath.equals(CONFIG_NODE_PATH + SUB_PATH)) {
						System.out.println("Configuration change detected, node path: " + configNodePath);
						
						// Read node data
						String jsonConfig = new String(event.getData().getData());
						System.out.println("Node " + CONFIG_NODE_PATH + " data: " + jsonConfig);
						
						// Convert configuration from json
						RedisConfig redisConfig = null;
						if (StringUtils.isNotBlank(jsonConfig)) {
							redisConfig = JsonUtils.jsonToPojo(jsonConfig, RedisConfig.class);
						}
						
						// If configuration is not empty, perform corresponding operations
						if (redisConfig != null) {
							String type = redisConfig.getType();
							String url = redisConfig.getUrl();
							String remark = redisConfig.getRemark();
							// Determine event type
							if (type.equals("add")) {
								System.out.println("New configuration detected, preparing to download...");
								// ... Connect to ftp server, find corresponding configuration based on url
								Thread.sleep(500);
								System.out.println("Start downloading new configuration file, download path: <" + url + ">");
								// ... Download configuration to your specified directory
								Thread.sleep(1000);
								System.out.println("Download successful, already added to project");
								// ... Copy file to project directory
							} else if (type.equals("update")) {
								System.out.println("Configuration update detected, preparing to download...");
								// ... Connect to ftp server, find corresponding configuration based on url
								Thread.sleep(500);
								System.out.println("Start downloading configuration file, download path: <" + url + ">");
								// ... Download configuration to your specified directory
								Thread.sleep(1000);
								System.out.println("Download successful...");
								System.out.println("Delete original configuration file in project...");
								Thread.sleep(100);
								// ... Delete original file
								System.out.println("Copy configuration file to project directory...");
								// ... Copy file to project directory
							} else if (type.equals("delete")) {
								System.out.println("Configuration deletion detected");
								System.out.println("Delete original configuration file in project...");
							}
							
							// TODO Restart service as needed
						}
					}
				}
			}
		});
		
		countDown.await();
		
		cto.closeZKClient();
	}
	
}

