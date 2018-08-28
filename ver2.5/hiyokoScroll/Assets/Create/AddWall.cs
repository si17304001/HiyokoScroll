using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class AddWall : MonoBehaviour {
	public GameObject wall1;
	
	// Use this for initialization
	void Start () {
		transform.position = new Vector2(Random.Range(10.0f, 100.0f),Random.Range(0.0f, 4.0f) );
		Instantiate(wall1,transform.position,transform.rotation);
	}
	
	// Update is called once per frame
	void Update () {
		
	}
}
