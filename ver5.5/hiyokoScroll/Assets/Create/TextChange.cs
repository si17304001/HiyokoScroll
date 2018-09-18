using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class TextChange : MonoBehaviour {
	public Text text;
	public int score;

	// Use this for initialization
	void Start () {
		score = 0;
	}
	
	// 毎フレーム呼び出される
	void Update () {
		string text1 = (GameController.point).ToString();
		text.text = "Score:"+text1;
		
			
	}


	
	
	
	void ResultScore(){
		text.text = "Score:"+(GameController.point).ToString();

	}
	
}
