package com.liferay.demo.info.collection.provider;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.liferay.info.collection.provider.CollectionQuery;
import com.liferay.info.collection.provider.InfoCollectionProvider;
import com.liferay.info.pagination.InfoPage;
import com.liferay.info.pagination.Pagination;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ListUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.json.XML;
import org.osgi.service.component.annotations.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * @author jverweij
 */
@Component(
		immediate = true,
		property = {
				// TODO enter required service properties
		},
		service = InfoCollectionProvider.class
)
public class RSSCollectionProvider implements InfoCollectionProvider<News> {

	CacheLoader<String, Object> loader = new CacheLoader<String, Object>() {
		@Override
		public String load(String key) {
			return key.toUpperCase();
		}
	};

	LoadingCache<String, Object> cache = CacheBuilder.newBuilder()
			.expireAfterWrite(2, TimeUnit.HOURS)
			.build(loader);

	@Override
	public String getLabel(Locale locale) {
		return LanguageUtil.get(locale,"news");
	}

	@Override
	public InfoPage<News> getCollectionInfoPage(CollectionQuery collectionQuery) {
		String url = "https://www.carecreations.basf.com/rssfeed.aspx";
		//String url = "https://www.nu.nl/rss";
		List<News> news = this.getNewsItems(url);

		Pagination pagination = collectionQuery.getPagination();

		return InfoPage.of(
				ListUtil.subList(
						news, pagination.getStart(), pagination.getEnd()),
				pagination, news.size());
	}

	private List<News> getNewsItems(String url) {
		List<News> news = new ArrayList();
		Integer id = 0;

		String xml = (String) cache.getIfPresent("rssresponse");
		if (xml == null) {
			xml = this.getRequest(RequestBuilder.get(url).build());
			cache.put("rssresponse",xml);
		}

		JSONObject jsonObject = XML.toJSONObject(xml);
		System.out.println(jsonObject.toString(2));

		DocumentContext jsonContext = JsonPath.parse(jsonObject.toString());
		List<HashMap> jsonpathItems = jsonContext.read("$..item.*");
		System.out.println(jsonpathItems.size() + " ");

		for (HashMap obj: jsonpathItems) {
			System.out.println(obj.get("link"));
			news.add(new News(id,(String)obj.get("title"),"",(String)obj.get("description"),(String)obj.get("link")));
			id++;
		}

		return news;
	}

	private String getRequest(HttpUriRequest request) {
		HttpClient client = HttpClientBuilder.create().build();

		HttpResponse response = null;
		try {
			response = client.execute(request);
			HttpEntity entity = response.getEntity();
			if (response.getStatusLine().getStatusCode() == 200) {
				return EntityUtils.toString(entity, "UTF-8");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "";
	}


}