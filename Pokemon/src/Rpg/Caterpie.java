package Rpg;

public class Caterpie extends PokemonAr { // n�o � prokemon de aar � pokemon do tipo inseto
	private int nivel = 0;
	private String dono;
	private String[] nomes = {"Caterpie","Metapod","Butterfree"};
	
	public Caterpie(String dono) 
	{
		super( 
				"Caterpie",
				113, // vida
				55, // ataque
				55,  // defesa
				0, // velocidade
				2.9, // peso
				0.3, // altura
				0, // xpMIn - escluir
				100
		);
		this.dono=dono;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getDono() {
		return dono;
	}

	public void setDono(String dono) {
		this.dono = dono;
	}
	
	public void recebeXp(int xp){ //atualizar nivel
		this.setXpMin( this.getXpMin() + xp );
		
		if( this.getXpMin() >= this.getXpMax() && (this.nomes.length-1)>this.nivel) {
			this.setXpMin(0);
			this.nivel++;
			involuir(nivel);
		}
	}
	
	public void involuir(int nivel) {
		this.setNome(nomes[nivel]);
		switch(nivel) {
		case 1:
			this.setVida(120);
			this.setAtaque(45);
			this.setDefesa(80);
			this.setAltura(0.7);
			this.setPeso(9.9);
		break;
		case 2:
			this.setVida(134);
			this.setAtaque(167);
			this.setDefesa(137);
			this.setAltura(1.1);
			this.setPeso(32);
		}
	}
	
	public double ataque(){
		return this.rand(this.getAtaque(), this.getAtaque() );
	}
	
	public double defesa(){
		return this.rand(this.getDefesa(), this.getDefesa() );
	}
	
	public void recebeDano(double dano) {
		double newDano = this.defesa() - dano; 
		if( newDano>0 ) {
			this.setVida( this.getVida()  - ( newDano ) );
		}
		else {
			System.out.println("O pok�mon "+this.getNome()+" n�o recebeu nenhum dano!");
		}
	}
	
	
	private double rand(double i, double j) {
		return  (i) - ( Math.random() * (j) );
	}
	
}
