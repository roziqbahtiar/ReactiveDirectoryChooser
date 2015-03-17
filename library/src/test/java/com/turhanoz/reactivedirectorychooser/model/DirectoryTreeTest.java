package com.turhanoz.reactivedirectorychooser.model;

import com.turhanoz.reactivedirectorychooser.event.CurrentRootDirectoryChangedEvent;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.RobolectricTestRunner;

import java.io.File;

import de.greenrobot.event.EventBus;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
public class DirectoryTreeTest{
   DirectoryTree sut;
    EventBus mockBus;

    @Before
    public void setUp() throws Exception {
        mockBus = mock(EventBus.class);
        sut = new DirectoryTree(mockBus);
    }

    @Test
    public void changingRootDirectoryShouldNotifyThroughBus() throws Exception {
        File mockRootDirectory = mock(File.class);
        CurrentRootDirectoryChangedEvent expectedEvent = new CurrentRootDirectoryChangedEvent(mockRootDirectory);

        sut.setRootDirectoryAndNotify(mockRootDirectory);

        verify(mockBus).post(eq(expectedEvent));
    }
}