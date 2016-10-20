package com.newshunt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CollectionSort {
	ArrayList<String> songList = new ArrayList<String>();
	ArrayList<Song> songObjList = new ArrayList<Song>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CollectionSort cs=new CollectionSort();
		cs.addSong();
		cs.display();	
		cs.sort();
		cs.display();
	}
	
	public void addSong(){
		songList.add("z");
		songList.add("x");
		songList.add("l");
		songList.add("k");
		songList.add("a");
		
		songObjList.add(new Song("Sarvam","Harish"));
		songObjList.add(new Song("Sivaji","Rahuman"));
		songObjList.add(new Song("3Idiots","Sham"));
		songObjList.add(new Song("Ashique2","Bharath"));
		songObjList.add(new Song("Three","Dhanush"));
		
	}
	public void display(){
		System.out.println(songList);
		
		System.out.println(songObjList);
		
	}
	public void sort(){
		Collections.sort(songList);
		Collections.sort(songObjList);
		ArtistCompare ArtCompare = new ArtistCompare();
		Collections.sort(songObjList,ArtCompare);
		
		System.out.println(" Before : "+songObjList);
		Collections.sort(songObjList, new Comparator<Song>() {
			public int compare(Song one, Song two) {
				System.out.println(one.getArtist()+"=="+two.getArtist());
				return one.getTitle().compareTo(two.getTitle());
			}
		});
		System.out.println(" On titile : "+songObjList);
		
		Collections.sort(songObjList, new Comparator<Song>() {
			public int compare(Song one, Song two) {
				System.out.println(one.getArtist()+"=="+two.getArtist());
				return one.getArtist().compareTo(two.getArtist());
			}
		});
		
		System.out.println(" On Artist : "+songObjList);
	}

}

class Song implements Comparable<Song>{
 String title;
 String artist;
 String nonSence;
 public int compareTo(Song s){
	 System.out.println(title+"=="+s.title);
	return nonSence.compareTo(s.nonSence);
 }
 
 Song(String title,String artist){
	 this.title = title;
	 this.artist = artist;
 } 
 public String getTitle(){
	 return title;
 }
 public String getArtist(){
	 return artist;
 }
 public String toString(){
	 return title;
 } 
 
	
}
class ArtistCompare implements Comparator<Song>{
	public int compare(Song one,Song two){
		System.out.println(one.getArtist()+"=="+two.getArtist());
		return one.getArtist().compareTo(two.getArtist());
	}
}


