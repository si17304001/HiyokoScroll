using UnityEngine;
using System.Collections;

public class Enemy : MonoBehaviour{

    // 変数の定義と初期化
    public float flap = 400f;
    public float flap2 = -300f;
    public static float scroll = -10f;
    public int colcount = 0;
    Rigidbody2D rb2d;
    public GameObject createOb;
    int encount;


    public static GameObject gameController; 
    void Awake(){
        gameController = GameObject.Find("GameController");
    }

    // Updateの前に1回だけ呼ばれるメソッド
    void Start(){
        // Rigidbody2Dをキャッシュする
        rb2d = GetComponent<Rigidbody2D>();
        encount = Player4.encount;
    }


    // シーン中にフレーム毎に呼ばれるメソッド
    void Update(){
    
    
    
    
    	
    	if(colcount == 1){
    		Destroy(this);
    	}
    	
    	
    	
    	if (GameController.isPlaying == true){
    		if(encount%2 == 0){	
        	
          

            	rb2d.velocity = new Vector2(scroll, rb2d.velocity.y);

        // xの正方向にscrollスピードで移動
        
				if(Player4.count%70== 0){
           			rb2d.velocity = Vector2.zero;
           			// (0,1)方向に瞬間的に力を加えて跳ねさせる
           			rb2d.AddForce(Vector2.up * flap, ForceMode2D.Impulse);
           		}
            }else{
            
            	rb2d.velocity = new Vector2(-10f, -2f);
            	if(Player4.count%70== 0){
           			rb2d.velocity = Vector2.zero;
           			// (0,1)方向に瞬間的に力を加えて跳ねさせる
           			rb2d.AddForce(Vector2.up * flap, ForceMode2D.Impulse);
           		}
            }
  
        }
        	
            

	}
        // xの正方向にscrollスピードで移動


      
        
        
        /*if(Player4.count%62 == 0){
        	scroll = 2f;
        	rb2d.velocity = Vector2.zero;
            // (0,1)方向に瞬間的に力を加えて跳ねさせる
            rb2d.AddForce(Vector2.up * flap2, ForceMode2D.Impulse);
        }*/

  		
    
    
     void OnCollisionEnter2D(Collision2D col)
    {
        if (col.gameObject.tag =="Death")
        {
            //scroll = 30f;
        	rb2d.velocity = Vector2.zero;
            // (0,1)方向に瞬間的に力を加えて跳ねさせる
            rb2d.AddForce(Vector2.up * flap, ForceMode2D.Impulse);
            colcount+=1;
            Debug.Log("接敵");

        }

    }
    

    
}

