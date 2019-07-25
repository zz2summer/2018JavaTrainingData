package cn.hncu.xh.bookStore.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *<p>Title:FileIOUtil</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 21, 2015
 */

/*
 * 代码抽取步骤：
 * 1、先不考虑写什么，把类似的代码拷到一起分析
 * 2、观察其中的变化部分和不变化的部分
 * 3、把这段代码中 用到的 前面定义的变量 抽取成方法的参数
 * 4、把 留给后面使用的 将在这段代码中新建的变量 定义成方法的返回值
 */
//这里是对文件进行直接的读取和存储
public class FileIOUtil {
	private FileIOUtil(){//工具类，把默认 构造方法私有化
	}
	@SuppressWarnings("unchecked")
	//从数据库中对应的文件中读取数据
	public static<A> List<A> readFromFile(String fileName) { //这里采用了泛型方法技术，就是我读的文件里是什么类型的元素，我返回出去的就是那种类型的元素
		File file=new File(fileName); //new一个file对象
		//判断这个file对象是否存在，如果不存在就需要自动创建这个file对象
		if(!file.exists()){ 
			try {
				file.createNewFile(); //创建file对象
			} catch (IOException e) {
				e.printStackTrace(); //弹出异常
			}
		}
		ObjectInputStream input=null;
		try {
			input=new ObjectInputStream(new FileInputStream(file)); //把需要的file对象写入到输入流中
			List<A> list=(List<A>)input.readObject(); //把file对象里面的元素一个个加入到list中，最后返回出去
			//如果file里面没有东西，就需要防护一下，给list new一个空对象，防止出现空指针异常
			if(list==null){
				list=new ArrayList<A>();
			}
			return list;
		} catch (IOException e) {//这里要注意ObjectInputStream读到最后一个对象时会抛出异常，所以这里出现异常时属于现象
			System.out.println("文件读取结束。。。"); //到了这一步就说明文件读取完成
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			if(input!=null){ //这里需要防护下，如果input为null，后面是不能关闭的
				try {
					input.close();
				} catch (IOException e) {
					throw new RuntimeException("文件关闭失败");
				}
			}
		}
		return new ArrayList<A>(); //返回list
	}
	//把数据写到对应的文件中放入数据库
	public static<A> boolean writeToFile(String fileName,List<A> list){  //使用泛型方法
		File file=new File(fileName); //new一个file对象
		ObjectOutputStream output=null;
		try {
			output=new ObjectOutputStream(new FileOutputStream(file)); //把文件写到输出流中
			output.writeObject(list); //把list整个写到output中，即对应的文件中
		} catch (IOException e) {
			return false; //如果放入失败，返回false
		}finally{
			if(output!=null){ ////这里需要防护下，如果output为null，后面是不能关闭的
				try {
					output.close();
				} catch (IOException e) {
					throw new RuntimeException("文件关闭失败。。。");
				}
			}
		}
		return true;
	}
}
