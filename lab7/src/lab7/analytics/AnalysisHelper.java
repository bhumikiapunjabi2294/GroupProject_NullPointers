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
 * @author BhumikaPunjabi
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

        System.out.println("5 most liked comments: ");
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

        float avgLikes = (float) TotalLikes / TotalComments;
        System.out.println("1. Average Likes per comment:" + avgLikes);
        System.out.println("TotalLikes:" + TotalLikes);
        System.out.println("TotalComments:" + TotalComments);

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

        System.out.println("2. Post with most liked comments:");

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
        int a = posts.get(maxId).getUserId();

        System.out.println("3. Post with Most Comments : " + max + "\n" +"Having Post ID:" + posts.get(maxId).getPostId());
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
                return o2.getTotalPost() - o1.getTotalPost();
            }
        });
        System.out.println("4. Top Five Inactive User By Total Posts : ");
        for (int i = 0; i < u.size() && i < 5; i++) {
            System.out.println("Inactive " + u.get(i) + "Total Posts :" + u.get(i).getTotalPost());
        }
    }
    public void topFiveInactiveUserbyTotalComments() {
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        List<User> commentList = new ArrayList<>(users.values());
        System.out.println(commentList);

        Collections.sort(commentList, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getComments().size() - o2.getComments().size();
            }
        });

        System.out.println("5. Top 5 inactive users based on comments:");
        for (int i = 0; i < commentList.size() && i < 5; i++) {
            System.out.println("Inactive "+commentList.get(i));

        }
    }

    //Top 5 inactive users overall (sum of comments, posts and likes)
    public void topFiveProActiveUserOverall() {
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
            int k = 0;
            for (Comment c : user.getComments()) {
                int TotalComments = 0;
                int likes = 0;
                if (userLikesCount.containsKey(user.getId())) {
                    likes = userLikesCount.get(user.getId());
                }
                likes += c.getLikes();
                k = likes + TotalComments + count;

            }
            user.setOverAll(k);
            u.add(user);
        }
        Collections.sort(u, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o2.getOverAll() - o1.getOverAll();
            }
        });
        System.out.println("7. Top 5 proactive users based on sum of comments, Posts and Likes:");
        for (int i = 0; i < u.size() && i < 5; i++) {
            System.out.println("Proactive " + u.get(i) + "Overall Activity Count: " + u.get(i).getOverAll());
        }
    }

    public void topFiveInActiveUserOverall() {
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
            int k = 0;
            for (Comment c : user.getComments()) {
                int TotalComments = 0;
                int likes = 0;
                if (userLikesCount.containsKey(user.getId())) {
                    likes = userLikesCount.get(user.getId());
                }
                likes += c.getLikes();
                k = likes + TotalComments + count;

            }
            user.setOverAll(k);
            u.add(user);
        }
        Collections.sort(u, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getOverAll() - o2.getOverAll();
            }
        });
        System.out.println("6. Top 5 inactive users based on sum of comments, Posts and Likes:");
        for (int i = 0; i < u.size() && i < 5; i++) {
            System.out.println("Inactive " + u.get(i)+ "Overall Activity Count: " + u.get(i).getOverAll());
        }
    }
}
