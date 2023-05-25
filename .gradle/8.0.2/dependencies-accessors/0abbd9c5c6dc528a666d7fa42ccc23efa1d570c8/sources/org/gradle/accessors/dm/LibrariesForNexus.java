package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the `nexus` extension.
*/
@NonNullApi
public class LibrariesForNexus extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final GradleLibraryAccessors laccForGradleLibraryAccessors = new GradleLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForNexus(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

    /**
     * Returns the group of libraries at gradle
     */
    public GradleLibraryAccessors getGradle() { return laccForGradleLibraryAccessors; }

    /**
     * Returns the group of versions at versions
     */
    public VersionAccessors getVersions() { return vaccForVersionAccessors; }

    /**
     * Returns the group of bundles at bundles
     */
    public BundleAccessors getBundles() { return baccForBundleAccessors; }

    /**
     * Returns the group of plugins at plugins
     */
    public PluginAccessors getPlugins() { return paccForPluginAccessors; }

    public static class GradleLibraryAccessors extends SubDependencyFactory {
        private final GradlePluginLibraryAccessors laccForGradlePluginLibraryAccessors = new GradlePluginLibraryAccessors(owner);

        public GradleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at gradle.plugin
         */
        public GradlePluginLibraryAccessors getPlugin() { return laccForGradlePluginLibraryAccessors; }

    }

    public static class GradlePluginLibraryAccessors extends SubDependencyFactory {

        public GradlePluginLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for publish (io.github.gradle-nexus:publish-plugin)
             * This dependency was declared in catalog nexus.toml
             */
            public Provider<MinimalExternalModuleDependency> getPublish() { return create("gradle.plugin.publish"); }

            /**
             * Creates a dependency provider for staging (io.codearte.gradle.nexus:gradle-nexus-staging-plugin)
             * This dependency was declared in catalog nexus.toml
             */
            public Provider<MinimalExternalModuleDependency> getStaging() { return create("gradle.plugin.staging"); }

    }

    public static class VersionAccessors extends VersionFactory  {

        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: publish (1.3.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog nexus.toml
             */
            public Provider<String> getPublish() { return getVersion("publish"); }

            /**
             * Returns the version associated to this alias: staging (0.22.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog nexus.toml
             */
            public Provider<String> getStaging() { return getVersion("staging"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for publish to the plugin id 'io.github.gradle-nexus.publish-plugin'
             * This plugin was declared in catalog nexus.toml
             */
            public Provider<PluginDependency> getPublish() { return createPlugin("publish"); }

    }

}
