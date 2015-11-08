package rwmidi;

import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Transmitter;

public class MidiInputBase {

	final protected javax.sound.midi.MidiDevice jDevice;

	/**
	 * Create a MidiInput from a javax.sound.midi.MidiDevice . Don't use this unless you know what you are doing.
	 * @param dev2
	 * @throws MidiUnavailableException
	 */
	public MidiInputBase(javax.sound.midi.MidiDevice dev2) throws MidiUnavailableException {
		this.jDevice = dev2;
		if (!dev2.isOpen())
			dev2.open();
	}


	public void setReceiver(Receiver midiListener) throws MidiUnavailableException {
		Transmitter trsmt = jDevice.getTransmitter();
		trsmt.setReceiver(midiListener);
	}
	

	public String getName() {
		javax.sound.midi.MidiDevice.Info info = jDevice.getDeviceInfo();
		return info.getName() + " " + info.getVendor();
	}

	/**
	 * Close the MIDI device attached to this input. This will close all the other inputs as well.
	 */
	public void closeMidi() {
		jDevice.close();
	}


}