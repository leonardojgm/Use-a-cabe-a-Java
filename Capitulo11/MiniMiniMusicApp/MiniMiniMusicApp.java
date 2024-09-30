import javax.sound.midi.* ;

public class MiniMiniMusicApp  {

	public static void main ( String [] args ) {
	
		MiniMiniMusicApp mini = new MiniMiniMusicApp () ;
		mini.play () ;

	} // fecha main

	public void play () {

		try {

			Sequencer player = MidiSystem.getSequencer () ;
			player.open () ;
			Sequence seq = new Sequence ( Sequence.PPQ , 4 ) ;
			Track track = seq.createTrack () ;
			ShortMessage first = new ShortMessage () ;
			first.setMessage ( 192 , 1 , 102 , 0 ) ;
			MidiEvent change = new MidiEvent ( first , 1 ) ;
			track.add ( change ) ;
			ShortMessage a = new ShortMessage () ;
			a.setMessage ( 144 , 1 , 44 , 100 ) ;
			MidiEvent noteOn = new MidiEvent ( a , 1 ) ;
			track.add ( noteOn ) ;
			ShortMessage b = new ShortMessage () ;
			b.setMessage ( 128 , 1 , 44 , 100 ) ;
			MidiEvent noteOff = new MidiEvent ( b , 16 ) ;
			track.add ( noteOff ) ;
 			player.setSequence ( seq ) ;
			player.start () ;
			Thread.sleep ( 1000 * 2 ) ; // inserir uma pausa para dar ao som de reproduzir
			player.close () ; // fechar a sequência
			System.exit ( 0 ) ; // sair da Aplicação Java
 
		} catch ( Exception ex ) {

			// e tudo mais...
			ex.printStackTrace () ;

		}

	} // fecha play

} // fecha classe