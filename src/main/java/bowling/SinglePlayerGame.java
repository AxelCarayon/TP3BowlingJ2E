package bowling;

/**
 * Cette classe a pour but d'enregistrer le nombre de quilles abattues lors des
 * lancés successifs d'<b>un seul et même</b> joueur, et de calculer le score
 * final de ce joueur
 */
public class SinglePlayerGame {

	public int tour;
        public boolean deuxiemeBoule;
        public int[] score;
        public int[] spareEtStrike;
        public String dernierLancer;
        
	public SinglePlayerGame() {
            this.tour = 0;
            this.deuxiemeBoule = false;
            this.score = new int[] {0,0,0,0,0,0,0,0,0,0};
            this.spareEtStrike = new int[]{0,0,0,0,0,0,0,0,0,0};
            this.dernierLancer = "";
	}

	/**
	 * Cette méthode doit être appelée à chaque lancé de boule
	 *
	 * @param nombreDeQuillesAbattues le nombre de quilles abattues lors de
	 * ce lancé
	 */
	public void lancer(int nombreDeQuillesAbattues) {
            
            //Strike
            if (this.tour<10){

                if (nombreDeQuillesAbattues <10 && this.deuxiemeBoule == false){
                    //premier lancer
                    compterPoints(nombreDeQuillesAbattues);
                    this.deuxiemeBoule = true;
                }
                else{
                    //second lancer ou strike
                    compterPoints(nombreDeQuillesAbattues);
                    this.deuxiemeBoule = false;
                    this.tour ++;

                }
            }
            if (this.tour == 10){
               if (this.spareEtStrike[9]==1){
                   this.dernierLancer="spare";
               }
               if (this.spareEtStrike[9]==2){
                   this.dernierLancer="strike";
               }
            }
            else{
            }
	}
        
        public void compterPoints(int pointsMarques){
            this.score[tour] += pointsMarques;
            if (this.score[tour] == 10 && this.deuxiemeBoule==true){
            this.spareEtStrike[tour] = 1;
        }
            if (this.score[tour] == 10 && this.deuxiemeBoule==false){
                this.spareEtStrike[tour] = 2;
            }
                
        }

	/**
	 * Cette méthode donne le score du joueur
	 *
	 * @return Le score du joueur
	 */
	public int score() {
		int total =0;
                for (int i=0;i<this.score.length-2;i++){
                    if (this.spareEtStrike[i] == 1){
                        total = total + this.score[i] +this.score[i+1];
                    }
                    else if(this.spareEtStrike[i] == 2){
                        total = total + this.score[i] + this.score[i+1] + this.score[i+2];
                    }
                }
                return total;
	}
}
