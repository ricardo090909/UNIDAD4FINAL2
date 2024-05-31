package enumeraciones;

public enum PuestoTrabajo {
	DIRECTOR{
		public String getPuesto() {
			return "Director";
		}
	},
	SUBDIRECTOR{
		public String getPuesto() {
			return "Subdirector";
		}
	},
	JEFE_DEPARTAMENTO{
		public String getPuesto() {
			return "Jefe de departamento";
		}
	},
	COORDINADOR{
		public String getPuesto() {
			return "Coordinador";
		}
	},
	DOCENTE{
		public String getPuesto() {
			return "Docente";
		}
	},
	AUXILIAR_ADMINISTRATIVO{
		public String getPuesto() {
			return "Auxiliar administrativo";
		}
	},
	PREFECTO{
		public String getPuesto() {
			return "Prefecto";
		}
	},
	BIBLIOTECARIO{
		public String getPuesto() {
			return "Bibliotecario";
		}
	},
	ORIENTADOR{
		public String getPuesto() {
			return "Orientador";
		}
	};
	
	public abstract String getPuesto();
}
