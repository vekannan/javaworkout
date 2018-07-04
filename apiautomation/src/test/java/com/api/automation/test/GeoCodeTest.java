package com.api.automation.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.api.automation.DTO.GeoCodeDTO;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class GeoCodeTest {

	private static Client jerseyClient = null;

	@BeforeClass
	public static void setup() {
		JacksonJsonProvider provider = new JacksonJsonProvider();
		//provider.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
		ClientConfig config = new ClientConfig().register(provider);
		jerseyClient = ClientBuilder.newClient(config);

	}

	@Test
	public void testGeoCodeApiWithZipCode() {
		Response response = jerseyClient.target("http://maps.googleapis.com/")
								.path("/maps/api/geocode/json")
								.queryParam("address", "94551")
								.request(MediaType.APPLICATION_JSON)
								.get();

		System.out.println("Status : " + response.getStatus());
		GeoCodeDTO geoCodeDTO = response.readEntity(GeoCodeDTO.class);
		Assert.assertEquals("OK", geoCodeDTO.getStatus());
	}
	
	/**
	 * Dummy test case for POST request validation. 
	 * 
	 * Add card details to an online account/profile
	 * 
	 * @throws Exception
	 */
	@Test
	public void addVisaCard() throws Exception {
		/*
		CreditCardDTO creditCardDTO = new CreditCardDTO();
		creditCardDTO.setType("CREDITCARD");
		creditCardDTO.setCardId("1234");
		creditCardDTO.setCardNumber("4445222299990007");
		creditCardDTO.setCardType("V");
		creditCardDTO.setPrimary(true);
		creditCardDTO.setExpMonth(5);
		creditCardDTO.setExpYear(2020);
		creditCardDTO.setBillingAddress(billingAddressDTO);

		WalletDTO wallet = client.target("http://11.168.104.187:85")
								.path("api/customer/v1/customers/" + userid + "/wallet/tenders")
								.request(MediaType.APPLICATION_XML)
								.header(Constants.HEADER_TOKEN, secureToken)
								.post(Entity.entity(creditCardDTO, MediaType.APPLICATION_XML), WalletDTO.class);

		assertTrue(wallet.getTenders() != null);
		*/
	}

}
