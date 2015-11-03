package fengke.model.command;

import java.util.ArrayList;
import java.util.List;

/**
 * 宏命令
 * 
 * @author 锋客
 * 
 *         简介： 所谓宏命令简单点说就是包含多个命令的命令，是一个命令的组合。
 *         设想茱丽的录音机有一个记录功能，可以把一个一个的命令记录下来，再在任何需要的时候重新把这些记录下来的命令一次性执行，
 *         这就是所谓的宏命令集功能。因此，茱丽的录音机系统现在有四个键，分别为播音、倒带、停止和宏命令功能。此时系统的设计与
 *         前面的设计相比有所增强，主要体现在Julia类现在有了一个新方法，用以操作宏命令键。
 * 
 */
public class CommandC {
	// 命令：
	interface Command {

		public void execute();
	}

	// 具体的宏命令实现的接口
	interface MacroCommand extends Command {
		/**
		 * 宏命令聚集的管理方法 可以添加一个成员命令
		 */
		public void add(Command cmd);

		/**
		 * 宏命令聚集的管理方法 可以删除一个成员命令
		 */
		public void remove(Command cmd);
	}

	// MacroAudioCommand类负责把个别的命令合成宏命令。
	public class MacroAudioCommand implements MacroCommand {

		private List<Command> commandList = new ArrayList<Command>();

		/**
		 * 宏命令聚集管理方法
		 */
		@Override
		public void add(Command cmd) {
			commandList.add(cmd);
		}

		/**
		 * 宏命令聚集管理方法
		 */
		@Override
		public void remove(Command cmd) {
			commandList.remove(cmd);
		}

		/**
		 * 执行方法
		 */
		@Override
		public void execute() {
			for (Command cmd : commandList) {
				cmd.execute();
			}
		}

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

	// 实现类
	class RewindCommand implements Command {

		private AudioPlayer myAudio;

		public RewindCommand(AudioPlayer audioPlayer) {
			myAudio = audioPlayer;
		}

		@Override
		public void execute() {
			myAudio.rewind();
		}

	}

	// 实现类
	class StopCommand implements Command {
		private AudioPlayer myAudio;

		public StopCommand(AudioPlayer audioPlayer) {
			myAudio = audioPlayer;
		}

		@Override
		public void execute() {
			myAudio.stop();
		}

	}

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

	public static void main(String[] args) {
		CommandC temp = new CommandC();
		// 创建接收者对象
		AudioPlayer audioPlayer = temp.new AudioPlayer();
		// 创建命令对象
		Command playCommand = temp.new PlayCommand(audioPlayer);
		Command rewindCommand = temp.new RewindCommand(audioPlayer);
		Command stopCommand = temp.new StopCommand(audioPlayer);

		MacroCommand marco = temp.new MacroAudioCommand();

		marco.add(playCommand);
		marco.add(rewindCommand);
		marco.add(stopCommand);
		marco.execute();
	}

}
