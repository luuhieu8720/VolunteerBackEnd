package codeproject.service;

import codeproject.model.Comment;
import codeproject.model.exception.ResourceNotFoundException;
import codeproject.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment getComment(Long id) {
        return commentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Comment is not exist with id: " + id));
    }

    public List<Comment> getAllComment() {
        return commentRepository.findAll();
    }

    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }
}
