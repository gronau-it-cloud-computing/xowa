/*
XOWA: the XOWA Offline Wiki Application
Copyright (C) 2012 gnosygnu@gmail.com

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as
published by the Free Software Foundation, either version 3 of the
License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package gplx.xowa.urls; import gplx.*; import gplx.xowa.*;
import org.junit.*; import gplx.xowa.html.hrefs.*;
import gplx.xowa.nss.*;
public class Xoa_url__to_str__tst {
	private final Xoa_url__to_str__fxt fxt = new Xoa_url__to_str__fxt();
	@Test   public void Http()				{fxt.Chk_to_str_href(Bool_.N, "http://a.org/b"						, "http://a.org/b");}
	@Test   public void File()				{fxt.Chk_to_str_href(Bool_.N, "file:///C/xowa/file/a.png"			, "file:///C/xowa/file/a.png");}
	@Test   public void Abrv__page()		{fxt.Chk_to_str_href(Bool_.N, "/wiki/A"								, "A");}
	@Test   public void Abrv__anch()		{fxt.Chk_to_str_href(Bool_.N, "#b"									, "#b");}
	@Test   public void Full__page()		{fxt.Chk_to_str_href(Bool_.Y, "/wiki/A"								, "en.wikipedia.org/wiki/A");}
	@Test   public void Full__anch()		{fxt.Chk_to_str_href(Bool_.Y, "#b"									, "en.wikipedia.org/wiki/Page_1#b");}
	@Test   public void Vnt() {
		Xowe_wiki zh_wiki = fxt.Prep_create_wiki("zh.wikipedia.org");
		gplx.xowa.parsers.vnts.Xop_vnt_parser_fxt.Vnt_mgr__init(zh_wiki.Lang().Vnt_mgr(), 0, String_.Ary("zh-hans", "zh-hant"));
		fxt.Chk_to_str_href(zh_wiki, Bool_.Y, "/site/zh.wikipedia.org/zh-hans/A"	, "zh.wikipedia.org/zh-hans/A");
		fxt.Chk_to_str_href(zh_wiki, Bool_.Y, "/site/zh.wikipedia.org/zh-hant/A"	, "zh.wikipedia.org/zh-hant/A");
		fxt.Chk_to_str_href(zh_wiki, Bool_.Y, "/site/zh.wikipedia.org/zh-cn/A"		, "zh.wikipedia.org/wiki/A");
		fxt.Chk_to_str_href(zh_wiki, Bool_.Y, "/site/zh.wikipedia.org/wiki/A"		, "zh.wikipedia.org/wiki/A");
	}
	@Test   public void Xwiki() {
		fxt.Prep_add_xwiki_to_user("fr.wikipedia.org");
		fxt.Chk_to_str_href(Bool_.N, "/site/fr.wikipedia.org/wiki/Page", "fr.wikipedia.org/wiki/Page");
	}
	@Test   public void Alias() {
		fxt.Prep_add_xwiki_to_wiki("wikt", "en.wiktionary.org");
		Xow_wiki en_d = fxt.Prep_create_wiki("en.wiktionary.org");
		en_d.Ns_mgr().Ns_main().Case_match_(Xow_ns_case_.Id_all);
		fxt.Chk_to_str_href(Bool_.N, "/wiki/wikt:a"	, "en.wiktionary.org/wiki/a");
	}
	@Test   public void Unknown()			{fxt.Chk_to_str_href(Bool_.N, "/wiki/{{{extlink}}}"					, "");}	// {{{extlink}}} not a valid title; return empty
}
class Xoa_url__to_str__fxt extends Xoa_url_parser_fxt { 	private final Xoh_href_parser href_parser = new Xoh_href_parser();
	public void Chk_to_str_href(boolean full, String raw, String expd) {Chk_to_str_href(cur_wiki, full, raw, expd);}
	public void Chk_to_str_href(Xowe_wiki wiki, boolean full, String raw, String expd) {
		href_parser.Parse_as_url(actl_url, Bry_.new_u8(raw), wiki, Bry__page);
		this.Chk_to_str(full, expd);
	}
	private static final byte[] Bry__page = Bry_.new_a7("Page_1");
}
