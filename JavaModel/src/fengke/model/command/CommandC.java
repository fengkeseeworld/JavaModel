package fengke.model.command;

import java.util.ArrayList;
import java.util.List;

/**
 * ������
 * 
 * @author ���
 * 
 *         ��飺 ��ν������򵥵�˵���ǰ����������������һ���������ϡ�
 *         ����������¼������һ����¼���ܣ����԰�һ��һ���������¼�����������κ���Ҫ��ʱ�����°���Щ��¼����������һ����ִ�У�
 *         �������ν�ĺ�������ܡ���ˣ�������¼����ϵͳ�������ĸ������ֱ�Ϊ������������ֹͣ�ͺ�����ܡ���ʱϵͳ�������
 *         ǰ���������������ǿ����Ҫ������Julia����������һ���·��������Բ������������
 * 
 */
public class CommandC {
	// ���
	interface Command {

		public void execute();
	}

	// ����ĺ�����ʵ�ֵĽӿ�
	interface MacroCommand extends Command {
		/**
		 * ������ۼ��Ĺ����� �������һ����Ա����
		 */
		public void add(Command cmd);

		/**
		 * ������ۼ��Ĺ����� ����ɾ��һ����Ա����
		 */
		public void remove(Command cmd);
	}

	// MacroAudioCommand�ฺ��Ѹ��������ϳɺ����
	public class MacroAudioCommand implements MacroCommand {

		private List<Command> commandList = new ArrayList<Command>();

		/**
		 * ������ۼ�������
		 */
		@Override
		public void add(Command cmd) {
			commandList.add(cmd);
		}

		/**
		 * ������ۼ�������
		 */
		@Override
		public void remove(Command cmd) {
			commandList.remove(cmd);
		}

		/**
		 * ִ�з���
		 */
		@Override
		public void execute() {
			for (Command cmd : commandList) {
				cmd.execute();
			}
		}

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

	// ʵ����
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

	// ʵ����
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

	public static void main(String[] args) {
		CommandC temp = new CommandC();
		// ���������߶���
		AudioPlayer audioPlayer = temp.new AudioPlayer();
		// �����������
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
