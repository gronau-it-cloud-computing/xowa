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
package gplx.xowa.files.origs; import gplx.*; import gplx.xowa.*; import gplx.xowa.files.*;
import gplx.core.flds.*;
import gplx.dbs.*; import gplx.xowa.files.fsdb.*;
import gplx.xowa.wikis.tdbs.metas.*;
public class Xof_orig_wkr__mock implements Xof_orig_wkr {
	private final    Ordered_hash hash = Ordered_hash_.New_bry();
	public byte				Tid() {return Xof_orig_wkr_.Tid_mock;}
	public void				Find_by_list(Ordered_hash rv, List_adp itms) {Xof_orig_wkr_.Find_by_list(this, rv, itms);}
	public Xof_orig_itm		Find_as_itm(byte[] ttl, int list_idx, int list_len) {
		return (Xof_orig_itm)hash.Get_by(ttl); // new Xof_orig_itm((byte)meta_itm.Vrtl_repo(), ttl, Xof_ext_.new_by_ttl_(ttl).Id(), meta_itm.Orig_w(), meta_itm.Orig_h(), meta_itm.Ptr_ttl());
	}
	public boolean				Add_orig(byte repo, byte[] page, int ext_id, int w, int h, byte[] redirect) {
		Xof_orig_itm itm = new Xof_orig_itm(repo, page, ext_id, w, h, redirect);
		hash.Add(page, itm);
		return false;
	}
	public void				Db_txn_save() {}
	public void				Db_rls() {}
}
