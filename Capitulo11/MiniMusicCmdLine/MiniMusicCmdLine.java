import javax.sound.midi.* ;

public class MiniMusicCmdLine  { // esse é o primeiro

	public static void main ( String [] args ) {
	
		MiniMusicCmdLine mini = new MiniMusicCmdLine () ;

		if ( args.length < 2 ) {

			System.out.println ( "Não se esqueça dos argumentos do instrumento e da nota" ) ;

		} else {

			int instrument = Integer.parseInt ( args [ 0 ] ) ;
			int note = Integer.parseInt ( args [ 1 ] ) ;
			mini.play ( instrument , note ) ;

		}

	} // fecha main

	public void play ( int instrument , int note ) {

		try {

			Sequencer player = MidiSystem.getSequencer () ;
			player.open () ;
			Sequence seq = new Sequence ( Sequence.PPQ , 4 ) ;
			Track track = seq.createTrack () ;

			MidiEvent event = null ;

			ShortMessage first = new ShortMessage () ;
			first.setMessage ( 192 , 1 , instrument , 0 ) ;
			MidiEvent changeInstrument = new MidiEvent ( first , 1 ) ;
			track.add ( changeInstrument ) ;

			ShortMessage a = new ShortMessage () ;
			a.setMessage ( 144 , 1 , note , 100 ) ;
			MidiEvent noteOn = new MidiEvent ( a , 1 ) ;
			track.add ( noteOn ) ;

			ShortMessage b = new ShortMessage () ;
			b.setMessage ( 128 , 1 , note , 100 ) ;
			MidiEvent noteOff = new MidiEvent ( b , 16 ) ;
			track.add ( noteOff ) ;

 			player.setSequence ( seq ) ;
			player.start () ;

			Thread.sleep ( 1000 * 2 ) ; // inserir uma pausa para dar ao som de reproduzir
			player.close () ; // fechar a sequência
			System.exit ( 0 ) ; // sair da Aplicação Java
 
		} catch ( Exception ex ) { ex.printStackTrace () ; }

	} // fecha play

} // fecha classe