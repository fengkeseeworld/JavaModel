package fengke.model.state;

import java.util.HashMap;
import java.util.Map;

/**
 * ����ͶƱϵͳ��Ӧ��
 * @author ���
 * 
 * ��飺Ҫʵ�ֿ���ͬһ���û�ֻ��ͶһƱ�����һ���û�����ͶƱ������ͶƱ��������5�Σ����ж�Ϊ����ˢƱ��Ҫȡ�����û�ͶƱ���ʸ񣬵�ȻͬʱҲҪȡ������Ͷ��Ʊ�����һ���û���ͶƱ��������8�Σ����������������ֹ�ٵ�¼��ʹ��ϵͳ��
 * 
 *
 */
public class StateB {
	public static void main(String[] args) {
		VoteManager vm = new VoteManager();
        for(int i=0;i<9;i++){
            vm.vote("u1","A");
        }

	}
	

}
//����״̬��
interface VoteState {
    /**
     * ����״̬��Ӧ����Ϊ
     * @param user    ͶƱ��
     * @param voteItem    ͶƱ��
     * @param voteManager    ͶƱ�����ģ�������ʵ��״̬��Ӧ�Ĺ��ܴ����ʱ��
     *                         ���Իص������ĵ�����
     */
    public void vote(String user,String voteItem,VoteManager voteManager);
}
//����״̬�ࡪ������ͶƱ
class NormalVoteState implements VoteState {

    @Override
    public void vote(String user, String voteItem, VoteManager voteManager) {
        //����ͶƱ����¼��ͶƱ��¼��
        voteManager.getMapVote().put(user, voteItem);
        System.out.println("��ϲͶƱ�ɹ�");
    }

}
//����״̬�ࡪ���ظ�ͶƱ
class RepeatVoteState implements VoteState {

    @Override
    public void vote(String user, String voteItem, VoteManager voteManager) {
        //�ظ�ͶƱ����ʱ��������
        System.out.println("�벻Ҫ�ظ�ͶƱ");
    }

}
//������״̬�ࡪ������ˢƱ
class SpiteVoteState implements VoteState {

    @Override
    public void vote(String user, String voteItem, VoteManager voteManager) {
        // ����ͶƱ��ȡ���û���ͶƱ�ʸ񣬲�ȡ��ͶƱ��¼
        String str = voteManager.getMapVote().get(user);
        if(str != null){
            voteManager.getMapVote().remove(user);
        }
        System.out.println("���ж���ˢ����Ϊ��ȡ��ͶƱ�ʸ�");
    }

}
//����״̬�ࡪ��������
class BlackVoteState implements VoteState {

    @Override
    public void vote(String user, String voteItem, VoteManager voteManager) {
        //��¼�������У���ֹ��¼ϵͳ
        System.out.println("���������������ֹ��¼��ʹ�ñ�ϵͳ");
    }

}
//������
class VoteManager {
    //����״�崦�����
    private VoteState state = null;
    //��¼�û�ͶƱ�Ľ����Map<String,String>��ӦMap<�û����ƣ�ͶƱ��ѡ��>
    private Map<String,String> mapVote = new HashMap<String,String>();
    //��¼�û�ͶƱ������Map<String,Integer>��ӦMap<�û����ƣ�ͶƱ�Ĵ���>
    private Map<String,Integer> mapVoteCount = new HashMap<String,Integer>();
    /**
     * ��ȡ�û�ͶƱ�����Map
     */
    public Map<String, String> getMapVote() {
        return mapVote;
    }
    /**
     * ͶƱ
     * @param user    ͶƱ��
     * @param voteItem    ͶƱ��ѡ��
     */
    public void vote(String user,String voteItem){
        //1.Ϊ���û�����ͶƱ����
        //�Ӽ�¼��ȡ�����û����е�ͶƱ����
        Integer oldVoteCount = mapVoteCount.get(user);
        if(oldVoteCount == null){
            oldVoteCount = 0;
        }
        oldVoteCount += 1;
        mapVoteCount.put(user, oldVoteCount);
        //2.�жϸ��û���ͶƱ���ͣ����൱���ж϶�Ӧ��״̬
        //����������ͶƱ���ظ�ͶƱ������ͶƱ�����Ϻ�������״̬
        if(oldVoteCount == 1){
            state = new NormalVoteState();
        }
        else if(oldVoteCount > 1 && oldVoteCount < 5){
            state = new RepeatVoteState();
        }
        else if(oldVoteCount >= 5 && oldVoteCount <8){
            state = new SpiteVoteState();
        }
        else if(oldVoteCount > 8){
            state = new BlackVoteState();
        }
        //Ȼ��ת��״̬������������Ӧ�Ĳ���
        state.vote(user, voteItem, this);
    }
}

