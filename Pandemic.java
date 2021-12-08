package praktikum0122021;
//In Zoom Gruppe Jan Seßler, Stephan Buchdunger
public class Pandemic
{
	/**
	 * Klasse zum Test von Blatt 7
	 *  
	 * @author Tobias Lauer
	 *
	 */
	
		
		// Variable f�r die (anf�ngliche) Gr��e der Population
		static final int POPULATION_SIZE = 500000;
		
		public static void main(String[] args) {
			// Erstelle eine Population
			
			Population p = new Population(POPULATION_SIZE);
					
			// Simulation
			// Starte mit Tag 0
			int day = 0;
			// Gib den aktuellen Tag, die Anzahl der Infizierten und die Anzahl der lebenden Individuen aus
			System.out.println("Tag "+day+": "+p.getIncidence()+" F�lle, Population: "+p.getCurrentSize());
			
			// Simuliere weitere Tage, solange es Infizierte und Lebendige gibt 
			while (p.getIncidence() > 0 && p.getCurrentSize() > 0) {
				// N�chsten Tag simulieren
				day++;
				p.simulateNextDay();	
				// Gib den aktuellen Tag, die Anzahl der Infizierten und die Anzahl der lebenden Individuen aus
				System.out.println("Tag "+day+": "+p.getIncidence()+" F�lle, Population: "+p.getCurrentSize());
			}
			
		}
	
}

//Bei der Simulation mit 5000 Personen haben 451 personen nach 588 Tagen überlebt.

//Was passiert, wenn man das Infektionsrisiko bei Kontakten um die Hälfte reduziert?
// - Es gibt weniger Fälle, da sich weniger leute untereinander anstecken

//Wie wirkt es sich aus, wenn die Mortalitätsrate auf 0.01 steigt
//- Es gibt viel mehr tote im verlauf der Pandemie

//Sie können auch Kontaktbeschränkungen simulieren, indem sie die Anzahl der Kontakte in der Methode simulateNextDay() verändern.
// - Durch Kontaktbeschränkungen gibt es weniger Fälle und gleichzeitig weniger Tote.