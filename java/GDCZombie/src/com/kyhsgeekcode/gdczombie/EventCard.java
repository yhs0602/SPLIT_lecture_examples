package com.kyhsgeekcode.gdczombie;

public abstract class EventCard {
	public abstract void Apply();
	
	public static final EventCard NewZombies = new EventCard() {
		@Override
		public void Apply() {
			Main.SpawnZombies();
			Main.MessageBox("새로운 좀비들이 발견되었습니다. 좀비들이 임의의 위치에 소환됩니다.", "좀비 자연발생");
		}
	};
	public static final EventCard NewCivilians = new EventCard() {
		@Override
		public void Apply() {
			Main.SpawnCivilians();
			Main.MessageBox("생존자들이 발견되었습니다. 시민들이 임의의 위치에 소환됩니다.", "생존자 발견");
		}
	};
	public static final EventCard Nothing = new EventCard() {
		@Override
		public void Apply() {
			System.out.println("아무 일도 일어나지 않았습니다.");
		}
	};
}
