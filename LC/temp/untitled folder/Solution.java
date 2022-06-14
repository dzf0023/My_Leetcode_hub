import java.util.ArrayList;
import java.util.List;

class TrieNode{
	TrieNode[] sons;
	boolean hasWord;
	String word;

	public TrieNode(){
		int i;
		sons = new TrieNode[26];
		for(i = 0; i < 26; ++i){
			sons[i] = null;
		}
		hasWord = false;
	}

	public static void Insert(TrieNode root, String wordStr){
		char[] word = wordStr.toCharArray();
		TrieNode p = root;
		int i;
		for(i = 0; i < word.length; ++i){
			int c = word[i] - 'a';
			if(p.sons[c] == null){
				p.sons[c] = new TrieNode();
			}
			p = p.sons[c];
		}
		p.hasWord = true;
		p.word = wordStr;
	}
}


public class Solution{
	char[] target = null;
	int K = 0;
	int [] f = null;
	int n = 0;
	List<String> res = null;

	private void dfs(TrieNode p,  int[] f){
		int[] nf = new int[n+1];

		if(p.hasWord){
			if(f[n] <= K){
				res.add(p.word);
			}
		}
		int i, j ,c;

		for(i = 0; i < 26; ++i){
			if(p.sons[i] == null){
				continue;
			}

			nf[0] = f[0] + 1;
			for(j = 1;  j <= n; ++j){
				nf[j] = Math.min(Math.min(nf[j-1] + 1, f[j] + 1), f[j-1] + 1);
				c = target[j-1] - 'a';
				if(c == i){
					nf[j] = Math.min(nf[j], f[j-1]);
				}
			}
			dfs(p.sons[i], nf);
		}
	}

	public List<String> KDistance(String[] words, String targetStr, int k){
		target = targetStr.toCharArray();
		n = target.length;
		K = k;
		res = new ArrayList<String>();

		TrieNode root = new TrieNode();

		for (int i = 0; i < words.length;  ++i) {
			TrieNode.Insert(root, words[i]);
		}

		f = new int[n+1];
		for(int i = 0; i<= n; ++i){
			f[i] = i;
		}
		dfs(root, f);
		return res;
	}

}









