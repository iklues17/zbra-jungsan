package com.hohans.king.jungsan.util;

import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.data.mongodb.repository.MongoRepository;

public class MockRepositoryTestUtil {

  public static <T> CapturedArg<T> stubRespositoryAdd(MongoRepository repository, Class<T> clazz) {
    CapturedArg<T> result = new CapturedArg<>();

    Mockito.when(repository.insert(Matchers.any(clazz))).thenAnswer(new Answer<Object>() {
      @Override
      public Object answer(InvocationOnMock invocation) throws Throwable {
        result.arg = (T) invocation.getArguments()[0];
        return result.arg;
      }
    });
    return result;
  }

}
