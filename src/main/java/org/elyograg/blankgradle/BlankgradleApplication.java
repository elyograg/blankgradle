package org.elyograg.blankgradle;

import java.lang.invoke.MethodHandles;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.Http2SolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@SpringBootApplication
public class BlankgradleApplication {

	private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	private static final Http2SolrClient sc = new Http2SolrClient.Builder("https://solr.elyograg.org/solr").build();

	public static void main(String[] args) {
//		SpringApplication.run(BlankgradleApplication.class, args);
		SolrQuery q = new SolrQuery("*:*");
		try {
			QueryResponse r = sc.query("dovecot", q);
			log.info("numFound {}", r.getResults().getNumFound());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Error!", e);
		} finally {
			sc.close();
		}
	}

}
