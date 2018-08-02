package GoF.behavioral.state;

public class StateRadioApp {
	public static void main(String[] args) {
		Station dfm = new RadioDFM();
		Radio radio = new Radio();
		radio.setStation(dfm);
		
		for(int i=0; i<10;i++){
			radio.play();
			radio.nextStation();
		}
	}
}
	interface Station {
		void play();
	}

	class Radio7 implements Station {
		public void play() {
			System.out.println("����� 7...");
		}
	}

	class RadioDFM implements Station {
		public void play() {
			System.out.println("����� DFM...");
		}
	}

	class VestiFM implements Station {
		public void play() {
			System.out.println("����� FM...");
		}
	}

	class Radio {
		Station station;

		void setStation(Station st) {
			station = st;
		}

		void nextStation() {
			if (station instanceof Radio7) {
				setStation(new RadioDFM());
			} else if (station instanceof RadioDFM) {
				setStation(new VestiFM());
			} else if (station instanceof VestiFM) {
				setStation(new Radio7());
			}
		}

		void play() {
			station.play();
		}
	}

