package enumeraciones;

public enum Genero {
	FEMENINO{
		public String getGender() {
			return "Femenino";
		}
	},MASCULINO{
		public String getGender() {
			return "Masculino";
		}
	};
	public abstract String getGender();
}