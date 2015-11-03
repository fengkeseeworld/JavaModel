package fengke.model.command;

/**
 * 实例
 * 
 * @author 锋客
 * 
 *         AudioPlayer系统
 * 
 *         简要说明： 小女孩茱丽(Julia)有一个盒式录音机，此录音机有播音(Play)、倒带(Rewind)和停止(Stop)功能，
 *         录音机的键盘便是请求者(Invoker)角色；茱丽(Julia)是客户端角色，而录音机便是接收者角色。
 * 
 *         Command类扮演抽象命令角色，而PlayCommand、StopCommand和RewindCommand便是具体命令类。
 *         茱丽(Julia)不需要知道播音(play)、倒带(rewind)和停止(stop)功能是怎么具体执行的，
 *         这些命令执行的细节全都由键盘(Keypad)具体实施。茱丽(Julia)只需要在键盘上按下相应的键便可以了。
 */
public class CommandB {

	// 录音机
	class AudioPlayer {
		public void play() {
			System.out.println("播放...");
		}

		public void rewind() {
			System.out.println("倒带...");
		}

		public void stop() {
			System.out.println("停止...");
		}

	}

	// 命令：
	interface Command {

		public void execute();
	}

	// 实现类
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
	
	//实现类
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
	//实现类
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
	
	//请求者
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
	     * 执行播放方法
	     */
	    public void play(){
	        playCommand.execute();
	    }
	    /**
	     * 执行倒带方法
	     */
	    public void rewind(){
	        rewindCommand.execute();
	    }
	    /**
	     * 执行播放方法
	     */
	    public void stop(){
	        stopCommand.execute();
	    }
	}
	//客户端
    public static void main(String[]args){
    	CommandB temp = new CommandB();
        //创建接收者对象
        AudioPlayer audioPlayer = temp.new AudioPlayer();
        //创建命令对象
        Command playCommand = temp.new PlayCommand(audioPlayer);
        Command rewindCommand = temp.new RewindCommand(audioPlayer);
        Command stopCommand = temp.new StopCommand(audioPlayer);
        //创建请求者对象
        Keypad keypad = temp.new Keypad();
        keypad.setPlayCommand(playCommand);
        keypad.setRewindCommand(rewindCommand);
        keypad.setStopCommand(stopCommand);
        //测试
        keypad.play();
        keypad.rewind();
        keypad.stop();
        keypad.play();
        keypad.stop();
    }
	

}
