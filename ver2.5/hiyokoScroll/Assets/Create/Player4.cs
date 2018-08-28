using UnityEngine;
using System.Collections;

public class Player4 : MonoBehaviour
{

    // 変数の定義と初期化
    public float flap = 400f;
    public static float scroll = 10f;
    Rigidbody2D rb2d;
    public Transform createPoint;
    public Transform spownPoint;
    public GameObject enemy;
    public static float countTime = 0;
    public GameObject createOb;
    public static long count;
    public static float kasoku = 2.0f;
    public static int encount = 0;
    int mode = 1;

    public static GameObject gameController;
    void Awake()
    {
        gameController = GameObject.Find("GameController");
    }

    // Updateの前に1回だけ呼ばれるメソッド
    void Start()
    {
        // Rigidbody2Dをキャッシュする
        rb2d = GetComponent<Rigidbody2D>();
        count = 0;
    }


    // シーン中にフレーム毎に呼ばれるメソッド
    void Update()
    {
    
    	if(Input.GetKeyDown("p")){
    		mode += 1;
    	}
        //countTime += Time.deltaTime;
        //if (countTime % 2 == 0) { Debug.Log("2秒立った"); }
       // Debug.Log(countTime.ToString());
        if (GameController.isPlaying == true)
        {
            rb2d.velocity = new Vector2(scroll, rb2d.velocity.y);

        }
        // xの正方向にscrollスピードで移動

        // スペースキーが押されたら
        if (Input.GetKeyDown(KeyCode.Space))
        {

            rb2d.velocity = Vector2.zero;
            // (0,1)方向に瞬間的に力を加えて跳ねさせる
            rb2d.AddForce(Vector2.up * flap, ForceMode2D.Impulse);
        }

    }
    void FixedUpdate() {
        
        if(GameController.isPlaying == true){
        	count++;
     	   if (count%500==0) {
     	       Debug.Log("1秒立った");
     	       addScroll();
     	       kasoku /= 2.0f;
     	   }
     	   
     	   if(count%3000 == 0){
     	   	SpownEnemy();
     	   	Debug.Log("敵出現");
     	   	   encount+=1;
     	   	
     	   }
     	   
     	   if(count%12000 == 0){
     	   	SpownEnemy2();
     	   	   encount+=1;
     	   }
     	}
    }
    
    


    void OnTriggerEnter2D(Collider2D col)
    {
        if (col.tag == "CountZone")
        {
            createObject();
            GameObject.Find("aa").SendMessage("AddScore", 1);
            GameObject.Find("Text").SendMessage("AddScore", 1);
        }
    }

    void OnCollisionEnter2D(Collision2D col)
    {
    	if(mode% 2 == 0 ){
    		if (col.gameObject.tag == "123Death")
        	{
            	gameController.SendMessage("GameOver");

        	}
    	}else{
        	if (col.gameObject.tag == "Death")
        	{
            	gameController.SendMessage("GameOver");

        	}
        }

    }
    void createObject()
    {
        //if ((int)countTime % 2 == 0)
      
           Debug.Log("2秒立った");
           GameObject createdWall= Instantiate(createOb, createPoint.position, Quaternion.identity) as GameObject;
    }
    void addScroll() {
        scroll += kasoku;
    }

	void SpownEnemy(){
		GameObject createdEnemy= Instantiate(enemy,spownPoint.position, Quaternion.identity) as GameObject;
	}
	
	void SpownEnemy2(){
		GameObject createdEnemy= Instantiate(enemy,spownPoint.position, Quaternion.identity) as GameObject;
	}

	
}

