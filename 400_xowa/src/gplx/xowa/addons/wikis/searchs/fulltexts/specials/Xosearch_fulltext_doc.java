/*
XOWA: the XOWA Offline Wiki Application
Copyright (C) 2012-2017 gnosygnu@gmail.com

XOWA is licensed under the terms of the General Public License (GPL) Version 3,
or alternatively under the terms of the Apache License Version 2.0.

You may use XOWA according to either of these licenses as is most appropriate
for your project on a case-by-case basis.

The terms of each license can be found in the source code repository:

GPLv3 License: https://github.com/gnosygnu/xowa/blob/master/LICENSE-GPLv3.txt
Apache License: https://github.com/gnosygnu/xowa/blob/master/LICENSE-APACHE2.txt
*/
package gplx.xowa.addons.wikis.searchs.fulltexts.specials; import gplx.*; import gplx.xowa.*; import gplx.xowa.addons.*; import gplx.xowa.addons.wikis.*; import gplx.xowa.addons.wikis.searchs.*; import gplx.xowa.addons.wikis.searchs.fulltexts.*;
import gplx.langs.mustaches.*;
public class Xosearch_fulltext_doc implements Mustache_doc_itm {
	private final    boolean case_match, auto_wildcard_bgn, auto_wildcard_end;
	private final    int max_pages_per_wiki, max_snips_per_page;
	private final    String wikis, namespaces;
	public Xosearch_fulltext_doc
		( boolean case_match, boolean auto_wildcard_bgn, boolean auto_wildcard_end
		, int max_pages_per_wiki, int max_snips_per_page
		, String wikis, String namespaces) {
		this.case_match = case_match;
		this.auto_wildcard_bgn = auto_wildcard_bgn;
		this.auto_wildcard_end = auto_wildcard_end;
		this.max_pages_per_wiki = max_pages_per_wiki;
		this.max_snips_per_page = max_snips_per_page;
		this.wikis = wikis;
		this.namespaces = namespaces;
	}
	public boolean Mustache__write(String key, Mustache_bfr bfr) {
		if		(String_.Eq(key, "wikis"))
			bfr.Add_str_u8(wikis);
		else if	(String_.Eq(key, "namespaces"))
			bfr.Add_str_u8(namespaces);
		else if	(String_.Eq(key, "max_pages_per_wiki"))
			bfr.Add_int(max_pages_per_wiki);
		else if	(String_.Eq(key, "max_snips_per_page"))
			bfr.Add_int(max_snips_per_page);
		else
			return false;
		return true;
	}
	public Mustache_doc_itm[] Mustache__subs(String key) {
		if		(String_.Eq(key, "case_match"))
			return Mustache_doc_itm_.Ary__bool(case_match);
		else if	(String_.Eq(key, "auto_wildcard_bgn"))
			return Mustache_doc_itm_.Ary__bool(auto_wildcard_bgn);
		else if	(String_.Eq(key, "auto_wildcard_end"))
			return Mustache_doc_itm_.Ary__bool(auto_wildcard_end);
		return Mustache_doc_itm_.Ary__empty;
	}
}
