using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class ResultScore : MonoBehaviour {
	public Text text;
	public int rscore;

	// Use this for initialization
	void Start () {
		rscore = 0;
	}
	
	// 毎フレーム呼び出される
	void Update () {
		string text1 = (rscore).ToString();
		text.text = "Score:"+text1;
		
			
	}
	
	void AddScore(int s){
		rscore = rscore + s;
		if(rscore < 0){
			rscore = 0;
		}
	}
	
}
