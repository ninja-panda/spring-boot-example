package com.tuturself.spring.boot.cassandra.manager;

import java.net.InetSocketAddress;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.HostDistance;
import com.datastax.driver.core.PlainTextAuthProvider;
import com.datastax.driver.core.PoolingOptions;
import com.google.common.collect.Lists;

import info.archinnov.achilles.generated.ManagerFactory;
import info.archinnov.achilles.generated.ManagerFactoryBuilder;

@Configuration
public class CassandraConfiguration {

	@Value("${cassandra.host}")
	private String cassandraHost;

	@Value("${cassandra.cluster.name}")
	private String clusterName;

	@Value("${cassandra.cluster.pooling.minThread}")
	private int minThread;

	@Value("${cassandra.cluster.pooling.maxThread}")
	private int maxThread;

	@Value("${cassandra.cluster.pooling.timeout}")
	private int timeout;

	@Value("${cassandra.keyspaces.keyspace.name}")
	private String keyspace;

	@Value("${cassandra.cluster.user}")
	private String userName;

	@Value("${cassandra.cluster.password}")
	private String password;

	@Bean(destroyMethod = "shutDown")
	public ManagerFactory cassandraNativeClusterProduction() {

		PoolingOptions poolingOptions = new PoolingOptions();
		poolingOptions.setMaxConnectionsPerHost(HostDistance.LOCAL, maxThread);
		poolingOptions.setPoolTimeoutMillis(timeout);
		poolingOptions.setCoreConnectionsPerHost(HostDistance.LOCAL, maxThread);
		PlainTextAuthProvider authProvider = new PlainTextAuthProvider(userName, password);
		Cluster cluster = Cluster.builder().addContactPointsWithPorts(convertToInternetAddress())
				.withClusterName(clusterName).withAuthProvider(authProvider).withPoolingOptions(poolingOptions).build();
		final ManagerFactory factory = ManagerFactoryBuilder
                .builder(cluster).doForceSchemaCreation(true).withDefaultKeyspaceName(keyspace)
                .build();
		return factory;
	}

	private List<InetSocketAddress> convertToInternetAddress() {

		List<InetSocketAddress> cassandraHosts = Lists.newArrayList();

		for (String host : cassandraHost.split(",")) {

			InetSocketAddress socketAddress = new InetSocketAddress(host.split(":")[0],
					Integer.valueOf(host.split(":")[1]));
			cassandraHosts.add(socketAddress);
		}

		return cassandraHosts;
	}
}
