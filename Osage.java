package おさげゲットチャレンジ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Osage {
	public static void main(String[] args) throws IOException {
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		String line = br.readLine();     //CDの収録時間を入力
		int totaltime = Integer.parseInt(line);     //int化

		String line2 = br.readLine();     //入力回数
		int num = Integer.parseInt(line2);     //int化

		int[] songtimeArray = new int[num];     //各曲の時間を代入する配列

		for(int i = 0; i < num; i++) {
			String line3 = br.readLine();     //num回だけ入力する
			int songtime = Integer.parseInt(line3);     //int化
			songtimeArray[i] = songtime;     //配列に代入
		}

		int count = 0;     //曲数をカウントする変数
		ArrayList<Integer> lastsongtimeList = new ArrayList<Integer>();     //次の曲を収録できるときのみ代入するリスト

		for(int j = 0; j < songtimeArray.length; j++) {
			if(j == 0) {     //はじめはCDの長さから1曲目の収録時間を計算
				lastsongtimeList.add(totaltime*60 - songtimeArray[j]);
				if(lastsongtimeList.get(j) > 0) {     //残り時間がある場合
					count++;     //変数をカウント
				} else {     //残り時間がない場合
					break;     //for文を抜け出す
				}
			} else {     //2曲目からは残りの収録時間から2曲目以降のCDの収録時間を計算
				lastsongtimeList.add(lastsongtimeList.get(j-1) - songtimeArray[j]);
				if(lastsongtimeList.get(j) > 0) {     //残り時間がある場合
					count++;     //変数をカウント
				} else {     //残り時間がない場合
					break;     //for文を抜け出す
				}
			}
		}

		if(lastsongtimeList.get(lastsongtimeList.size() - 1) > 0) {      //収録時間に余裕がある場合
			System.out.println("OK");     //OKと出力
		} else {     //ない場合
			System.out.println(count);     //曲数を出力
		}
	}
}
