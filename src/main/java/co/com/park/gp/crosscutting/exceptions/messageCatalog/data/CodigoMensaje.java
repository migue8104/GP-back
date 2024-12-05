package co.com.park.gp.crosscutting.exceptions.messageCatalog.data;

import static co.com.park.gp.crosscutting.helpers.TextHelper.concatenate;
import static co.com.park.gp.crosscutting.helpers.TextHelper.UNDERLINE;;

public enum CodigoMensaje {

	M00001(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00001", true),
	M00002(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00002", true),
	M00003(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00003", true),
	M00004(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00004", true),
	M00005(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00005", true),
	M00006(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00006", true),
	M00007(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00007", true),
	M00008(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00008", true),
	M00009(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00009", true),
	M00010(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00010", true),
	M00011(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00011", true),
	M00012(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00012", true),
	M00013(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00013", true),
	M00014(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00014", true),
	M00015(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00015", true),
	M00016(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00016", true),
	M00017(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00017", true),
	M00018(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00018", true),
	M00019(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00019", true),
	M00020(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00020", true),
	M00021(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00021", true),
	M00022(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00022", true),
	M00023(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00023", true),
	M00024(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00024", true),
	M00025(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00025", true),
	M00026(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00026", true),
	M00027(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00027", true),
	M00028(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00028", true),
	M00029(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00029", true),
	M00030(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00030", true),
	M00031(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00031", true),
	M00032(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00032", true),
	M00033(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00033", true),
	M00034(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00034", true),
	M00035(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00035", true),
	M00036(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00036", true),
	M00037(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00037", true),
	M00038(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00038", true),
	M00039(TipoMensaje.TECNICO, CategoriaMensaje.EXITO, "00039", true),
	M00040(TipoMensaje.TECNICO, CategoriaMensaje.EXITO, "00040", true),
	M00041(TipoMensaje.TECNICO, CategoriaMensaje.EXITO, "00041", true),
	M00042(TipoMensaje.TECNICO, CategoriaMensaje.EXITO, "00042", true),
	M00043(TipoMensaje.TECNICO, CategoriaMensaje.EXITO, "00043", true),
	M00044(TipoMensaje.TECNICO, CategoriaMensaje.EXITO, "00044", true),
	M00045(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00045", true),
	M00046(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00046", true),
	M00047(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00047", true),
	M00048(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00048", true),
	M00049(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00049", true),
	M00050(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00050", true),
	M00051(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00051", true),
	M00052(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00052", true),
	M00053(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00053", true),
	M00054(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00054", true),
	M00055(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00055", true),
	M00056(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00056", true),
	M00057(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00057", true),
	M00058(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00058", true),
	M00059(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00059", true),
	M00060(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00060", true),
	M00061(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00061", true),
	M00062(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00062", true),
	M00063(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00063", true),
	M00064(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00064", true),
	M00065(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00065", true),
	M00066(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00066", true),
	M00067(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00067", true),
	M00068(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00068", true),
	M00069(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00069", true),
	M00070(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00070", true),
	M00071(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00071", true),
	M00072(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00072", true),
	M00073(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00073", true);

	private TipoMensaje tipo;
	private CategoriaMensaje categoria;
	private String codigo;
	private boolean base;

	private CodigoMensaje(TipoMensaje tipo, CategoriaMensaje categoria, String codigo, boolean base) {
		setTipo(tipo);
		setCategoria(categoria);
		setCodigo(codigo);
		setBase(base);
	}

	public final TipoMensaje getTipo() {
		return tipo;
	}

	public final CategoriaMensaje getCategoria() {
		return categoria;
	}

	public final String getCodigo() {
		return codigo;
	}

	public final boolean isBase() {
		return base;
	}

	private final void setTipo(TipoMensaje tipo) {
		this.tipo = tipo;
	}

	private final void setCategoria(CategoriaMensaje categoria) {
		this.categoria = categoria;
	}

	private final void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	private final void setBase(boolean base) {
		this.base = base;
	}

	public String getIdentificador() {
		return concatenate(getTipo().name(), UNDERLINE, getCategoria().name(), UNDERLINE, getCodigo());
	}

}
