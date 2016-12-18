package repositorio.mauro.cuquejo.com.github.cheeseplease1;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Game;

public class CheesePlease1 extends Game {
	
	private SpriteBatch batch;
	
	private Texture mouseyTexture;
	private float mouseyX;
	private float mouseyY;
	
	private Texture cheeseTexture;
	private float cheeseX;
	private float cheeseY;
	
	private Texture floorTexture;
	private Texture winMessage;
	
	private boolean win;
	
	public void create(){
		
		batch = new SpriteBatch();
		
		mouseyTexture = new Texture(Gdx.files.internal("assets/mouse.png"));
		mouseyX = 20;
		mouseyY = 20;
				
	    cheeseTexture = new Texture(Gdx.files.internal("assets/cheese.png"));
	    cheeseX = 400;
	    cheeseY = 300;
	    
	    floorTexture = new Texture(Gdx.files.internal("assets/tiles.jpg"));
	    winMessage = new Texture(Gdx.files.internal("assets/you-win.png"));
	    
	    win = false;
	}
	
	public void render(){
		//chequea entrada de usuario
		if (Gdx.input.isKeyPressed(Keys.LEFT))
			mouseyX--;
		if (Gdx.input.isKeyPressed(Keys.RIGHT))
			mouseyX++;
		if (Gdx.input.isKeyPressed(Keys.UP))
			mouseyY++;
		if (Gdx.input.isKeyPressed(Keys.DOWN))
			mouseyY--;
		
		//chequea condicion de victoria: mousey debe solaparse con el queso
		if ((mouseyX > cheeseX)
			&& (mouseyX + mouseyTexture.getWidth() < cheeseX + cheeseTexture.getWidth())
			&& (mouseyY < cheeseY)
			&& (mouseyY + mouseyTexture.getHeight() < cheeseY + cheeseTexture.getHeight()))
			win = true;
		
		
		//limpiar pantalla y dibujar graficos
		Gdx.gl.glClearColor(0.8F, 0.8F, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		batch.draw(floorTexture,0,0);
		batch.draw(cheeseTexture, cheeseX,cheeseY);
		batch.draw(mouseyTexture, mouseyX, mouseyY);
		if (win)
			batch.draw(winMessage,170,60);
		batch.end();
	}

}
