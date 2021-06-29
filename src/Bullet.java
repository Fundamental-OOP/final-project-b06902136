import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Bullet extends Weapon{
	private int x, y;
	public ArrayList<Brick> BrickList;
	public Bullet(ArrayList<Brick> bList) {
		BrickList = bList;
		super.count = 1;
	}
	
	@Override
	public boolean perform(Player user, Player enemy) {
		if(new Rectangle(getX(), getY(), 10, 10)
				.intersects(new Rectangle(enemy.X, enemy.Y, 50, 50)))
				{
					user.score += 10;
					enemy.lives -= 1;
					user.Shoot = false;
					user.shootDirection = "";
					return true;
				}
		for(Brick br:BrickList)
			if(br.collisionCheck(1, getX(), getY(), 10, 10))
			{
				user.Shoot = false;
				user.shootDirection = "";	
				return true;
			}
		if(getY() < 1 
				|| getY() > 580
				|| getX() < 1
				|| getX() > 630)
		{
			user.Shoot = false;
			user.shootDirection = "";
			return true;
		}
		return false;
	}
	
	

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void move(String face) {
		if(face.equals("right"))
			x += 5;
		else if(face.equals("left"))
			x -= 5;
		else if(face.equals("up"))
			y -= 5;
		else
			y +=5;
	}

	@Override
	public void draw(Component c, Graphics g) {
		g.setColor(Color.yellow);
		g.fillOval((int) x, (int) y, 10, 10);
	}

	@Override
	public Weapon create() {
		return new Bullet(BrickList);
	}
	
	@Override
	public Weapon releaseNewOne(){
		
		return create();
		}

	
}
