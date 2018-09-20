using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using System.IO;
using System.Text;

public class FileManeger {
    string filePath = @"C:\Users\nozaw\Desktop\ver5.5\hiyokoScroll\Assets\Create\result.txt";
    public bool WriteFile(string str) {
        try
        {
            using (var writer = new StreamWriter(filePath,true))
            { //  ファイルがなかった場合は新規で作成される。あったら上書きされる。
                writer.WriteLine(str);
            }
            return true;
        }
        catch (IOException e)
        {
            return false;
        }
        
    }

    public List<string> ReadFile() {
        var list = new List<string>();
        try
        {
            using (var reader = new StreamReader(filePath, Encoding.UTF8))
            {
                while (!reader.EndOfStream)
                {
                    var line = reader.ReadLine();
                    list.Add(line);
                }
            }
        }
        catch (IOException e) {
            list = null;
        }
        
        return list;
    }
    

}
