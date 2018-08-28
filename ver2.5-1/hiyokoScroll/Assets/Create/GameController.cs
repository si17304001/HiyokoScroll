﻿using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class GameController : MonoBehaviour {
	public static GameObject player; //Playerオブジェクト
	public static GameObject start; //Start画面
	public static GameObject gameOver; //GameOver画面
	public static bool isPlaying; //Play状態の変数(falseでプレイしていない、trueでプレイ中)
	public static GameObject score; //Score画面
	public static GameObject rscore;
    public static GameObject wall1;
    public static GameObject wall2;
    //public static Transform iti1;
    //public static Transform iti2;
    public static Transform createPoint;
    public static float countTime = 0;


    void Awake () {
	
		//player/Start/gameOver/score/result全てを取得
		player = GameObject.Find("Player4");
		start = GameObject.Find("Start");
		gameOver = GameObject.Find("GameOver");
		score = GameObject.Find("aa");
		rscore = GameObject.Find("Text");
        wall1 = GameObject.Find("wall1");
        wall2 = GameObject.Find("wall2");
        //iti1 = wall1.transform;
        //iti2 = wall2.transrom;

    }
	
	
	
	
	
	/*開始時にGameOver,isPlayingともにFalseをSet
	ゲーム開始にはくっりくしてTrueに入れ替えが必要*/
	void Start(){
		gameOver.SetActive(false);
		rscore.SetActive(false);
		isPlaying = false;
		
		
	}
	
	//毎フレーム呼び出される
	void Update () {
        
		if(Input.GetKeyDown(KeyCode.Space)){
			isPlaying = true;
			start.SetActive(false);
			
		}
		if(Input.GetKeyDown("a")){
			gameOver.SetActive(false);
			
			isPlaying = true;
			SceneManager.LoadScene ("SampleScene");
		}
		
		
	}
	
	//GameOver時isPlayingがtrueならfalseに変更してgameOverを表示,Player、Scoreを消す
	void GameOver(){
		if(isPlaying == true){
		isPlaying = false;
		gameOver.SetActive(true);
		rscore.SetActive(true);
		rscore.SendMessage("ResultScore");
		player.SetActive(false);
		score.SetActive(false);
		rscore.SetActive(true);
		}
	}
	
	
	
	
	
    
	
	
}