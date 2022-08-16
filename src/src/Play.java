// Play interface with stop, getCurrentStream, and stream method signatures
public interface Play {
	public void stop();

	public DigitalContent getCurrentStream();

	public void stream(String query);
}
