package com.tuturself.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class ConsulConfiguration {

    @Value("${cassandra.host}")
    private String cassandraHost;

    @Value("${cassandra.user}")
    private String userName;

    @Value("${cassandra.password}")
    private String password;

    @Value("${cassandra.pooling.maxThread}")
    private int maxThread;

    @Value("${cassandra.pooling.timeout}")
    private int timeout;

    @Value("${cassandra.keyspace.name}")
    private String keyspace;

    @Value("${cassandra.keyspace.readConsistency}")
    private String readConsistency;

    @Value("${cassandra.keyspace.writeConsistency}")
    private String writeConsistency;

    @Override
    public String toString() {
        return "ConsulConfiguration{" +
                "cassandraHost='" + cassandraHost + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", maxThread=" + maxThread +
                ", timeout=" + timeout +
                ", keyspace='" + keyspace + '\'' +
                ", readConsistency='" + readConsistency + '\'' +
                ", writeConsistency='" + writeConsistency + '\'' +
                '}';
    }
}
