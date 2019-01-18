package io.hgdb.client.services;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import pro.ibpm.mercury.config.MercuryConfig;
import pro.ibpm.mercury.lucene.LuceneModelVersion;

public class LuceneHelper {

	/**
	 * Nazwa pola indeksu Lucene zawierającego identyfikator dokumentu w modelu w
	 * wersji 2 nazewnictwa pól.
	 */
	public static final String LUCENE_DOCUMENT_ID_FIELD_NAME_MRC_2 = "luceneDocId";

	/**
	 * Prefiks dodawany do nazw pól (pola stałe, obiektu) w modelu wersji 3
	 * nazewnictwa pól.
	 */
	public static final String LUCENE_FIELD_NAME_PREFIX_MRC_3 = "mrc_";

	/**
	 * w celu optymalizacji tworzonych obiektów z nazwą identyfikatora dokumentu
	 * Lucene przechowywane one są w postaci mapy.
	 * 
	 * @see #getLuceneIdFieldName(Class)
	 */
	private static final Map<Class<?>, String> luceneIdFieldNamesMap = new HashMap<Class<?>, String>();

	/**
	 * Pobieranie nazwy pola identyfikatora dokumentu Lucene w zależności od klasy
	 * encji
	 * 
	 * @param clazz
	 *            klasa encji
	 * @return nazwa pola identyfikatora dokumentu.
	 */
	public static String getLuceneIdFieldName(Class<?> clazz) {

		String fieldName = luceneIdFieldNamesMap.get(clazz);
		if (StringUtils.isBlank(fieldName)) {
			final String clazzSimpleName = clazz.getSimpleName();
			LuceneModelVersion version = MercuryConfig.getLuceneModelVersion();
			if (version.equals(LuceneModelVersion.MRC_2)) {
				fieldName = LUCENE_DOCUMENT_ID_FIELD_NAME_MRC_2;
			} else {
				if (clazzSimpleName.equals("Case")) {
					fieldName = LUCENE_FIELD_NAME_PREFIX_MRC_3 + clazzSimpleName + "_id";
				} else {
					fieldName = clazzSimpleName + "_id";
				}
			}
			luceneIdFieldNamesMap.put(clazz, fieldName);
		}
		return fieldName;
	}

}
