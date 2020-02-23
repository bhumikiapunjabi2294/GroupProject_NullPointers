/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7.analytics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lab7.entities.Comment;
import lab7.entities.Post;
import lab7.entities.User;

/**
 *
 * @author harshalneelkamal
 */
public class AnalysisHelper {
    // find user with Most Likes
    //  key: UserId ; Value: sum of likes from all comments
    public void userWithMostLikes() {
        Map<Integer, Integer> userLikesCount = new HashMap<>();
        Map<Integer, User> users = DataStore.getInstance().getUsers();
    
        for (User user : users.values()) {
            for (Comment c : user.getComments()) {
                int likes = 0;
                if (userLikesCount.containsKey(user.getId())) {
                    likes = userLikesCount.get(user.getId());
                }
                likes += c.getLikes();
                userLikesCount.put(user.getId(), likes);
            }
        }
        int max = 0;
        int maxId = 0;
        for (int id : userLikesCount.keySet()) {
            if (userLikesCount.get(id) > max) {
                max = userLikesCount.get(id);
                maxId = id;
            }
        }
        System.out.println("User with most likes: " + max + "\n" 
            + users.get(maxId));
    }
    
    // find 5 comments which have the most likes
    public void getFiveMostLikedComment() {
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        List<Comment> commentList = new ArrayList<>(comments.values());
        
        Collections.sort(commentList, new Comparator<Comment>() {
            @Override 
            public int compare(Comment o1, Comment o2) {
                return o2.getLikes() - o1.getLikes();
            }
        });
        
        System.out.println("5 most likes comments: ");
        for (int i = 0; i < commentList.size() && i < 5; i++) {
            System.out.println(commentList.get(i));
        }
    }
    
    //Find the average number of likes per comment.

     public void avgLikesPerComment() {
        Map<Integer, Integer> userLikesCount = new HashMap<>();
        Map<Integer, User> users = DataStore.getInstance().getUsers();

        int TotalComments = 0;

        for (User user : users.values()) {
            for (Comment c : user.getComments()) {
                TotalComments++;
                int likes = 0;
                if (userLikesCount.containsKey(user.getId())) {
                    likes = userLikesCount.get(user.getId());
                }
                likes += c.getLikes();
                userLikesCount.put(user.getId(), likes);
            }
        }

        int TotalLikes = 0;
        for (int id : userLikesCount.keySet()) {

            TotalLikes += userLikesCount.get(id);

        }
        System.out.println(TotalComments);
        System.out.println(TotalLikes);
        System.out.println("Avg=" + TotalLikes / TotalComments);

    }
     
     //Find the post with most liked comments
      public void mostLikedComment() {
      Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        List<Comment> commentList = new ArrayList<>(comments.values());
        
        Collections.sort(commentList, new Comparator<Comment>() {
            @Override 
            public int compare(Comment o1, Comment o2) {
                return o2.getLikes() - o1.getLikes();
            }
        });
        
        System.out.println("Most liked comment: ");
      
            System.out.println(commentList.get(0));
     }
      //Find the post with most comments
      public void postWithMostComments() {
         Map<Integer, Integer> userPost = new HashMap<>();
         Map<Integer, Post> posts = DataStore.getInstance().getPosts();
         
         
         
         for (Post post : posts.values()) {
            for (Comment c : post.getComments()) {
                
                int Comment = 0;
                
                if (userPost.containsKey(post.getPostId())) {
                    Comment = userPost.get(post.getPostId());
                }
                Comment += post.getPostId();
                userPost.put(post.getPostId(), Comment);
            }
        }
        int max = 0;
        int maxId = 0;
        for (int id : userPost.keySet()) {
            if (userPost.get(id) > max) {
                max = userPost.get(id);
                maxId = id;
            }
        }
        int a=posts.get(maxId).getUserId();
        
        System.out.println("Post with most Comments: " + max+" Post ID is :" +posts.get(maxId).getPostId());
    }
      //Top 5 inactive users based on total posts number
    public void userWithLeastPosts() {
       
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
      //  List<Post> arraylist = new ArrayList<Post>(posts.values()); 
        ArrayList<User> u = new ArrayList<>();
        ////new start
       //  Map<Integer, Integer> userPostCount = new HashMap<>();
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        for (User user : users.values()) {
            int count = 0;
            for (Post p : posts.values()) {                
                if (user.getId() == p.getUserId()) {
                    count++;
                }                                 
            }       
            user.setTotalPost(count);
            u.add(user);
          //  userPostCount.put(user.getId(),count);        
        }
        Collections.sort(u, new Comparator<User>() {
            @Override 
            public int compare(User o1, User o2) {
                return o2.getTotalPost()- o1.getTotalPost();
            }
        });
        System.out.println("Top Five User by total post :");
        for(int i=0;i<u.size() && i<5; i++){
            System.out.println("   "+u.get(i).getFirstName() +"         "+ u.get(i).getTotalPost());
        }
        /*
     //   Collections.sort(postList, Collections.reverseOrder());
        //new method
        System.out.println(userPostCount);
        List<Integer> a= new ArrayList<Integer>(userPostCount.values());
        List<Integer> b= new ArrayList<Integer>(userPostCount.values());
        System.out.println(a + "yash--------------------------------------------------");
       // Collections.sort(a);
        System.out.println(a);
        List<Integer> c = new ArrayList<>();
        c.add(1);
        c.add(2);
        c.add(3);
        c.add(4);
        c.add(5);
        c.add(6);
        c.add(7);
        c.add(8);
        c.add(9);
        c.add(10);
        System.out.println(c);
        int temp=0;
        for(int k=1;k<c.size();k++){
            if(a.get(k)>a.get(k-1)){
                temp = a.get(k);
        //        a.get(k-1)=temp;
                
            }
        }
        
        for(int i=0;i<5;i++){
            for(int j=0;j<a.size()-1;j++){
                if(a.get(i)==b.get(j)){
                    System.out.println("user ID :"+j);
                    break;
                }
            }
        }
        */
        //shorting karavanu baki 6
    }
    
    
    //Inactive user by comments
    public void topFiveInactiveUserbyTotalComments(){
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        List<User> commentList = new ArrayList<>(users.values());
         System.out.println(commentList);
         
         Collections.sort(commentList, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return  o1.getComments().size() - o2.getComments().size();
            } 
        });  
         
         System.out.println("5. Top 5 inactive users based on comments:");
        for(int i = 0; i<commentList.size() && i <5; i++){
       System.out.println(commentList.get(i));
    
        }
     }
    
    
    //Top 5 inactive users overall (sum of comments, posts and likes)
    public void topFiveProActiveUserOverall(){
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        Map<Integer, Integer> userLikesCount = new HashMap<>();
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        ArrayList<User> u = new ArrayList<>();
        
        for (User user : users.values()) {
            int count = 0;
            for (Post p : posts.values()) {  
                
                if (user.getId() == p.getUserId()) {
                    count++;
                }                                 
            }
            int k=0;
            for (Comment c : user.getComments()) {
                int TotalComments = 0;
                int likes = 0;
                if (userLikesCount.containsKey(user.getId())) {
                    likes = userLikesCount.get(user.getId());
                }
                likes += c.getLikes();
                 k=likes+TotalComments+count;
                                
            }
            user.setOverAll(k);
                u.add(user);
        }
        Collections.sort(u, new Comparator<User>() {
            @Override 
            public int compare(User o1, User o2) {
                return o2.getOverAll()- o1.getOverAll();
            }
        });
        System.out.println("Top Five User Overall :");
        for(int i=0;i<u.size() && i<5; i++){
            System.out.println("   "+u.get(i).getFirstName() +"         "+ u.get(i).getOverAll());
        }
    }
    public void topFiveInActiveUserOverall(){
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        Map<Integer, Integer> userLikesCount = new HashMap<>();
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        ArrayList<User> u = new ArrayList<>();
        
        for (User user : users.values()) {
            int count = 0;
            for (Post p : posts.values()) {  
                
                if (user.getId() == p.getUserId()) {
                    count++;
                }                                 
            }
            int k=0;
            for (Comment c : user.getComments()) {
                int TotalComments = 0;
                int likes = 0;
                if (userLikesCount.containsKey(user.getId())) {
                    likes = userLikesCount.get(user.getId());
                }
                likes += c.getLikes();
                 k=likes+TotalComments+count;
                                
            }
            user.setOverAll(k);
                u.add(user);
        }
        Collections.sort(u, new Comparator<User>() {
            @Override 
            public int compare(User o1, User o2) {
                return o1.getOverAll()- o2.getOverAll();
            }
        });
        System.out.println("Top Five User Overall :");
        for(int i=0;i<u.size() && i<5; i++){
            System.out.println("   "+u.get(i).getFirstName() +"         "+ u.get(i).getOverAll());
        }
    }
}