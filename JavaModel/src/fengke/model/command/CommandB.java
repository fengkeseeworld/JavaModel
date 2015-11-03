package fengke.model.command;

/**
 * ʵ��
 * 
 * @author ���
 * 
 *         AudioPlayerϵͳ
 * 
 *         ��Ҫ˵���� СŮ������(Julia)��һ����ʽ¼��������¼�����в���(Play)������(Rewind)��ֹͣ(Stop)���ܣ�
 *         ¼�����ļ��̱���������(Invoker)��ɫ������(Julia)�ǿͻ��˽�ɫ����¼�������ǽ����߽�ɫ��
 * 
 *         Command����ݳ��������ɫ����PlayCommand��StopCommand��RewindCommand���Ǿ��������ࡣ
 *         ����(Julia)����Ҫ֪������(play)������(rewind)��ֹͣ(stop)��������ô����ִ�еģ�
 *         ��Щ����ִ�е�ϸ��ȫ���ɼ���(Keypad)����ʵʩ������(Julia)ֻ��Ҫ�ڼ����ϰ�����Ӧ�ļ�������ˡ�
 */
public class CommandB {

	// ¼����
	class AudioPlayer {
		public void play() {
			System.out.println("����...");
		}

		public void rewind() {
			System.out.println("����...");
		}

		public void stop() {
			System.out.println("ֹͣ...");
		}

	}

	// ���
	interface Command {

		public void execute();
	}

	// ʵ����
	public class PlayCommand implements Command {

		private AudioPlayer myAudio;

		public PlayCommand(AudioPlayer audioPlayer) {
			myAudio = audioPlayer;
		}


		@Override
		public void execute() {
			myAudio.play();
		}

	}
	
	//ʵ����
	class RewindCommand implements Command {

	    private AudioPlayer myAudio;
	    
	    public RewindCommand(AudioPlayer audioPlayer){
	        myAudio = audioPlayer;
	    }
	    @Override
	    public void execute() {
	        myAudio.rewind();
	    }

	}
	//ʵ����
	class StopCommand implements Command {
	    private AudioPlayer myAudio;
	    
	    public StopCommand(AudioPlayer audioPlayer){
	        myAudio = audioPlayer;
	    }
	    @Override
	    public void execute() {
	        myAudio.stop();
	    }

	}
	
	//������
	class Keypad {
	    private Command playCommand;
	    private Command rewindCommand;
	    private Command stopCommand;
	    
	    public void setPlayCommand(Command playCommand) {
	        this.playCommand = playCommand;
	    }
	    public void setRewindCommand(Command rewindCommand) {
	        this.rewindCommand = rewindCommand;
	    }
	    public void setStopCommand(Command stopCommand) {
	        this.stopCommand = stopCommand;
	    }
	    /**
	     * ִ�в��ŷ���
	     */
	    public void play(){
	        playCommand.execute();
	    }
	    /**
	     * ִ�е�������
	     */
	    public void rewind(){
	        rewindCommand.execute();
	    }
	    /**
	     * ִ�в��ŷ���
	     */
	    public void stop(){
	        stopCommand.execute();
	    }
	}
	//�ͻ���
    public static void main(String[]args){
    	CommandB temp = new CommandB();
        //���������߶���
        AudioPlayer audioPlayer = temp.new AudioPlayer();
        //�����������
        Command playCommand = temp.new PlayCommand(audioPlayer);
        Command rewindCommand = temp.new RewindCommand(audioPlayer);
        Command stopCommand = temp.new StopCommand(audioPlayer);
        //���������߶���
        Keypad keypad = temp.new Keypad();
        keypad.setPlayCommand(playCommand);
        keypad.setRewindCommand(rewindCommand);
        keypad.setStopCommand(stopCommand);
        //����
        keypad.play();
        keypad.rewind();
        keypad.stop();
        keypad.play();
        keypad.stop();
    }
	

}
