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
package gplx.xowa.xtns.wbases.claims; import gplx.*; import gplx.xowa.*; import gplx.xowa.xtns.*; import gplx.xowa.xtns.wbases.*;
public class Wbase_references_grp {
	public Wbase_references_grp(Wbase_claim_grp_list references, int[] references_order) {this.references = references; this.references_order = references_order;}
	public Wbase_claim_grp_list References() {return references;} private Wbase_claim_grp_list references;
	public int[] References_order() {return references_order;} private int[] references_order;
}