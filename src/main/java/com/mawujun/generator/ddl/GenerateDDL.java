package com.mawujun.generator.ddl;

import java.util.EnumSet;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;


public class GenerateDDL {

	public static void main(String[] args) {
		ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
	    Metadata metadata = new MetadataSources(registry).buildMetadata();
	    SchemaExport export = new SchemaExport();
	    export.create(EnumSet.of(TargetType.DATABASE),metadata);

	}

}
