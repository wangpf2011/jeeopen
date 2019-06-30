package com.jeeopen.web.tags.html.resolver;

import java.io.InputStream;
import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;

/**
 * hibernate动态sql dtd解析器
 * http://blog.csdn.net/hailanzhijia/article/details/6004947
 * http://blog.csdn.net/a9529lty/article/details/6671364
 * 
 * @author wangpf
 * 
 */
@SuppressWarnings("serial")
public class HtmlComponentDTDEntityResolver implements EntityResolver, Serializable {
	private static final Logger LOGGER = LoggerFactory.getLogger(HtmlComponentDTDEntityResolver.class);
	private static final String HOP_DYNAMIC_STATEMENT = "http://www.jeeopen.com/dtd/";

	public InputSource resolveEntity(String publicId, String systemId) {
		InputSource source = null; // returning null triggers default behavior
		if (systemId != null) {
			LOGGER.debug("trying to resolve system-id [" + systemId + "]");
 			if (systemId.startsWith(HOP_DYNAMIC_STATEMENT)) {
				LOGGER.debug(
						"recognized hop html component namespace attempting to resolve on classpath under com/jeeopen/core/tags/html/dtd/");
				source = resolveOnClassPath(publicId, systemId, HOP_DYNAMIC_STATEMENT);
			}
		}
		return source;
	}

	private InputSource resolveOnClassPath(String publicId, String systemId, String namespace) {
		InputSource source = null;
		String path = "dtd/html-component-1.0.dtd";
		InputStream dtdStream = resolveInHtmlNamespace(path );
		if ( dtdStream == null ) {

		}
		else {
			LOGGER.debug( "Located [%s] in classpath", systemId );
			source = new InputSource( dtdStream );
			source.setPublicId( publicId );
			source.setSystemId( systemId );
		}
		return source;
	}

	protected InputStream resolveInHtmlNamespace(String path) {
		return this.getClass().getClassLoader().getResourceAsStream( path );
	}
}