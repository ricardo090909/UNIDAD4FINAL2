package enumeraciones;

public enum TipoDirectivo {
	SUBDIRECTOR_ACADEMICO{
		public String getTipoDirectivo() {
			return "Subdirector academico";
		}
	},
	SUBDIRECTOR_ADMINISTRATIVO{
		public String getTipoDirectivo() {
			return "Subdirector administrativo";
		}
	};
	
	public abstract String getTipoDirectivo();
}
