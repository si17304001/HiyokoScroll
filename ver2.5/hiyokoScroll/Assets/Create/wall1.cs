using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class wall1 : MonoBehaviour {
	
	int count;
	// Use this for initialization
	void Start () {
		count = 0;
	}
	
	// Update is called once per frame
	void Update(){
		if(count == 5000){
				Destroy(this,3.0f);
		}
			
	}
	
	void FixedUpdate(){
		count++;
	}
}
