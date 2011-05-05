package com.pacman.entity.direction;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.newdawn.slick.Animation;

import com.pacman.geometry.CollisionPolygon;
import com.pacman.graphics.AnimationFactory;

public class DownTest {

	@Test
	public void shouldMovePolygonToTheLeft() throws Exception {
		Float delta = 1f;
		AnimationFactory animationFactory = mock(AnimationFactory.class);
		Animation animation = mock(Animation.class);
		CollisionPolygon polygon = mock(CollisionPolygon.class);
		CollisionPolygon response = mock(CollisionPolygon.class);

		when(animationFactory.from("down", Direction.ANIMATION_DELAY))
				.thenReturn(animation);
		when(polygon.translate(0, delta)).thenReturn(response);

		Direction direction = new Down(animationFactory);

		assertSame(response, direction.move(polygon, delta));
		assertSame(animation, direction.getAnimation());

		verify(polygon).translate(0, delta);
	}
}
