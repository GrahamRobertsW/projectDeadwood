public class HotelTile extends tile{
	HotelTile(int pos){
		private String[] names = {'Hotel', 'Bank', 'Church'}
		private tempRoles[][]={{new role('Faro Player', 'Hit Me!', 1), new role('Sleeping Drunkard', 'Zzzzzz Whiskey', 1), new role('Australian Bartender', "What'll it be, mate?", 3), new role('Falls from Balcony', 'Arrrgghh!!', 2)},{new role('Flustered Teller', 'Would you like a large bill, sir?', 3), new role('Suspicious Gentleman', 'Can you be more specific?', 2)},{new role('Dead Man', '...', 1), new role('Crying Woman', "oh, the humanity!", 2)}}
		private int[] shots = {3,1,2}
		for (i=0, i<Names.size, i++){
			role temp=new role(names[i], tempRoles[i], shots[i]);
			insert into this.rooms(temp.getName(), temp);
	}
	}
